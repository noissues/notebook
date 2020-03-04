package com.community.controller;

import com.community.dto.AccessTokenRequestDTO;
import com.community.dto.GitHubUser;
import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    String clientId;

    @Value("${github.client.secret}")
    String clientSecret;

    @Value("${github.redirect.uri}")
    String redirectUri;

    @Autowired
    private UserMapper userMapper;

    /**
     * 处理 http://localhost:8887/callback?code=e4cc256178b1535fab00&state=1
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenRequestDTO accessTokenRequest = new AccessTokenRequestDTO();
        accessTokenRequest.setClient_id(clientId);
        accessTokenRequest.setClient_secret(clientSecret);
        accessTokenRequest.setCode(code);
        accessTokenRequest.setRedirect_uri(redirectUri);
        accessTokenRequest.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenRequest);
        GitHubUser gitHubUser = gitHubProvider.getGitHubUser(accessToken);
        // 重命名过用户名的情况
        if (gitHubUser != null && gitHubUser.getName() == null) {
            gitHubUser.setName(gitHubUser.getLogin());
        }

        if (gitHubUser != null) {
            // 通过 githubUser 创建 user 并入库
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(gitHubUser.getName());
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);

            // 使用 GitHub 认证成功，将 user 信息写入 session，可以直接从前端取到显示在页面上，且刷新也是登录态
            request.getSession().setAttribute("user", gitHubUser);
            return "redirect:/";
        } else {
            // TODO
            return "redirect:/";  // 不想 github 返回的 callback 地址显示在地址栏，故重新请求 根路径
        }
    }
}
