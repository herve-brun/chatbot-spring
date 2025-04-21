package fr.laposte.banque;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * Controller managing interactions for the assistant functionality.
 */
@RestController
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.NONE)
class AssistantController {

    /**
     * The assistant service used to handle chat operations.
     */
    final Assistant assistant;

    /**
     * Handles incoming chat requests and returns a stream of responses.
     *
     * @param message The input message from the user.
     * @return A Flux of Strings representing the chat response, with an error fallback message.
     */
    @GetMapping("/chat")
    public Flux<String> chat(String message) {
        return assistant.chat(message)
                .onErrorReturn("An error occurred during the request");
    }
}

