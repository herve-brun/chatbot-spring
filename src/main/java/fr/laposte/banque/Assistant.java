package fr.laposte.banque;

import static dev.langchain4j.service.spring.AiServiceWiringMode.AUTOMATIC;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService(wiringMode = AUTOMATIC, streamingChatModel = "gemma3:27b")
interface Assistant {

    /**
     * This method allows the user to interact with an AI assistant.
     * The method takes a string input representing the user's message and returns a
     * flux of strings, which represents the AI's response in streaming format.
     * 
     * @param userMessage The message sent by the user to the AI assistant.
     * @return A stream of strings containing the AI's response, allowing for
     *         real-time interaction and dynamic updates as the response is
     *         generated.
     */
    @SystemMessage("Tu es un assistant génial qui répond toujours uniquement en français")
    Flux<String> chat(String userMessage);
}