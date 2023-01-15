package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("no spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        System.out.println(memberService);
        System.out.println(memberService1);

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    @DisplayName("singleton call")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();


        Assertions.assertThat(instance1).isSameAs(instance2);
        // sameAs -> ==
        // equal -> equals
    }

    @Test
    @DisplayName("spring container singleton")
    void springSingletonTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
