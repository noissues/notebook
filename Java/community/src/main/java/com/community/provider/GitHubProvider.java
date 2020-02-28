package com.community.provider;

import com.alibaba.fastjson.JSON;
import com.community.dto.AccessTokenRequestDTO;
import com.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {

    /**
     * 用户认证后返回的 code， 再用来请求 accessToken
     * @param accessTokenRequestDTO
     * @return
     */
    public String getAccessToken(AccessTokenRequestDTO accessTokenRequestDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        // 用 fastJson 将 dto 转为 json 串
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenRequestDTO), mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {

            // 返回格式为：access_token=eb52b13106261361d903473ba0a873b503e3ef00&scope=user&token_type=bearer
            String responseStr = response.body().string();
            String accessToken = responseStr.split("&")[0].split("=")[1];
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // 执行到这返回 null
    }

    /**
     * 通过 GitHub 提供的 API https://api.github.com/user，获取 User 的信息
     * @param accessToken
     * @return
     */
    public GitHubUser getGitHubUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();

        // Authorization: token OAUTH-TOKEN
        // GET https://api.github.com/user
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "token " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            // 返回的 response 应该是 json 格式，故这里直接 fastjson转为 GitHubUser
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
