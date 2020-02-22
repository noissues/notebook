package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan 自动化装配使用
public class CDPlayerConfig {
    
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgrPeppers() {
        return new SgtPeppers();
    }
    
    // @Bean // 自定义创建 bean 的方式
    // public CompactDisc randomBeatlesCD() {
    //     int choice = (int) Math.floor(Math.random() * 4);
    //     if (choice == 0) {
    //         return new SgtPeppers();
    //     } else if (choice == 1) {
    //         return null;
    //     } else {
    //         return null;
    //     }
    // }
    
    // @Bean // 方式1
    // public CDPlayer cdPlayer() {
    //     return new CDPlayer(sgrPeppers());
    // }
    
    // @Bean // 通过 构造函数 注入
    // public CDPlayer cdPlayer(CompactDisc compactDisc) {
    //     return new CDPlayer(compactDisc);
    // }
    
    // @Bean // 通过 Setter 注入
    // public CDPlayer cdPlayer(CompactDisc compactDisc) {
    //     CDPlayer cdPlayer = new CDPlayer();
    //     cdPlayer.setCompactDisc(compactDisc);
    //     return cdPlayer;
    // }
}
