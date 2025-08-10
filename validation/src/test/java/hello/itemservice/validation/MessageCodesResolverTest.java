package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("rejected", "item");
        Assertions.assertThat(messageCodes).contains("rejected.item","rejected");
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("rejected", "item", "itemName", String.class);
        Assertions.assertThat(messageCodes).contains("rejected.item.itemName","rejected.itemName","rejected.java.lang.String","rejected");
    }
}
