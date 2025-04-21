package fr.laposte.banque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.listener.ChatModelErrorContext;
import dev.langchain4j.model.chat.listener.ChatModelListener;
import dev.langchain4j.model.chat.listener.ChatModelRequestContext;
import dev.langchain4j.model.chat.listener.ChatModelResponseContext;

/**
 * Configuration class that provides a custom ChatModelListener bean for
 * debugging purposes.
 */
@Configuration
class MyConfiguration {

    /**
     * Creates and returns an instance of the custom ChatModelListener.
     * <p>
     * This listener logs information about each request, response,
     * and any errors that occur during the processing of a chat model.
     */
    @Bean
    ChatModelListener chatModelListener() {
        return new ChatModelListener() {

            private static final Logger log = LoggerFactory.getLogger(MyConfiguration.class);

            /**
             * Logs the incoming request information whenever a request is made to the chat
             * model.
             */
            @Override
            public void onRequest(ChatModelRequestContext requestContext) {
                log.info("onRequest(): {}", requestContext.chatRequest());
            }

            /**
             * Logs the received response information whenever a response is received from
             * the chat model.
             */
            @Override
            public void onResponse(ChatModelResponseContext responseContext) {
                log.info("onResponse(): {}", responseContext.chatResponse());
            }

            /**
             * Logs any errors that occur during the processing of a request by the chat
             * model.
             */
            @Override
            public void onError(ChatModelErrorContext errorContext) {
                log.info("onError(): {}", errorContext.error().getMessage());
            }
        };
    }
}
