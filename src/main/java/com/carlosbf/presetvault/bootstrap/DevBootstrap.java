package com.carlosbf.presetvault.bootstrap;

import com.carlosbf.presetvault.model.Pack;
import com.carlosbf.presetvault.model.SocialMediaLink;
import com.carlosbf.presetvault.model.User;
import com.carlosbf.presetvault.repositories.PackRepository;
import com.carlosbf.presetvault.repositories.SocialMediaLinkRepository;
import com.carlosbf.presetvault.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.carlosbf.presetvault.model.SocialMediaLink.SocialMediaType;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private SocialMediaLinkRepository socialMediaLinkRepository;
    private PackRepository packRepository;

    public DevBootstrap(UserRepository userRepository, SocialMediaLinkRepository socialMediaLinkRepository, PackRepository packRepository) {
        this.userRepository = userRepository;
        this.socialMediaLinkRepository = socialMediaLinkRepository;
        this.packRepository = packRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        User emplexx = new User("emplexx", "blank", "emplexx");
        SocialMediaLink sml = new SocialMediaLink("face", SocialMediaType.DISCORD);
        emplexx.getSocialMediaLinks().add(sml);

        Pack p = new Pack("dope pack");
        p.setOwner(emplexx);

        User teslaX = new User("Tesla", "blank", "teslax");
        User ravitex = new User("Ravi", "tex", "ravitex");

        socialMediaLinkRepository.save(sml);
        userRepository.save(teslaX);
        userRepository.save(ravitex);

        teslaX.follow(emplexx);
        ravitex.follow(emplexx);
        emplexx.follow(emplexx);

        System.out.println(emplexx);
        System.out.println(teslaX);
       // System.out.println(ravitex);

        userRepository.save(emplexx);

        packRepository.save(p);



    }


}
