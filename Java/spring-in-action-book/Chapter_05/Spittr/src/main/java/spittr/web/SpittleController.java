package spittr.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  @Autowired // 注入 SpittleRepository 依赖
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  // 写法1：返回最新的 spittle 列表
  // @RequestMapping(method=RequestMethod.GET)
  // public String spittles(Model model) {
  //   // 不声明属性 key
  //   model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
  //   // 声明属性 key
  //   model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
  //   return "spittles";
  // }
  // 写法2：使用 Map 代替 Model
  // @RequestMapping(method=RequestMethod.GET)
  // public String spittles(Map model) {
  //   model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
  //   return "spittles";
  // }
  // 写法3：返回最新的 spittle 列表
  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return spittleRepository.findSpittles(max, count);
  }

  // 写法1：处理 /spittles/show?spittle_id=12345 这样的情况
  @RequestMapping(value="/show", method=RequestMethod.GET)
  public String showSpittle(
      @RequestParam("spittle_id") long spittleId,
      Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }
  // 写法2：处理 /spittles/12345 当请求某个 id 的文章时，找到这篇文章并添加到 model 中
  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId, 
      Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }

  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
        form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }

}
