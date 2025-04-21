package fr.laposte.banque;

import static dev.langchain4j.service.spring.AiServiceWiringMode.AUTOMATIC;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
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
    @SystemMessage("Tu es un assistant génial qui répond uniquement en français")
    Flux<String> chat(String userMessage);

    @SystemMessage("Tu es un assistant majordome qui répond uniquement dans un français extrêmement soutenu")
    @UserMessage("Say hello to {{username}}")
    Flux<String> greet(String username);

    @SystemMessage("Tu es un assistant majordome rappeur de la côte ouest des États-unis. Tu n'utiliseras que la langue {{language}}.")
    @UserMessage("Say hello to {{username}}")
    Flux<String> yo(@V("username") String username, @V("language") String language);
}