package fr.laposte.banque;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * Controller managing interactions for the assistant functionality.
 */
@RestController
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.NONE)
class AssistantController {

    /**
     * The assistant service used to handle chat operations.
     */
    Assistant assistant;

    /**
     * Handles incoming chat requests and returns a stream of responses.
     *
     * @param message The input message from the user.
     * @return A Flux of Strings representing the chat response, with an error
     *         fallback message.
     */
    @GetMapping(path = "/chat", produces = "text/event-stream")
    public Flux<String> chat(String message) {
        return assistant.chat(message)
                .onErrorReturn("An error occurred during the request");
    }

    @GetMapping(path = "/greet", produces = "text/event-stream")
    public Flux<String> greet(String username) {
        return assistant.greet(username)
                .onErrorReturn("An error occurred during the request");
    }

    @GetMapping(path = "/yo", produces = "text/event-stream")
    public Flux<String> yo(String username, String language) {
        return assistant.yo(username, language)
                .onErrorReturn("An error occurred during the request");
    }

}
