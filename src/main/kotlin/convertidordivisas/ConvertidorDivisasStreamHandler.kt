package convertidordivisas

import com.amazon.ask.Skill
import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.amazon.ask.builder.CustomSkillBuilder
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import com.amazon.ask.request.handler.GenericRequestHandler
import convertidordivisas.handlers.*
import java.util.*

class ConvertidorDivisasStreamHandler : SkillStreamHandler(skill {
    handler { CancelandStopIntentHandler() }
    handler { ConvertIntentHandler() }
    handler {
        val x = 2
        val y = 5
        HelpIntentHandler(x + y)
    }
    handler { LaunchRequestHandler() }
    handler { SessionEndedRequestHandler() }
})

/**
 * Let's build a skill!!
 */
inline fun skill(buildSkillBlock: CustomSkillBuilder.() -> Unit): Skill {
    val customSkill = Skills.custom()
    customSkill.buildSkillBlock()
    return customSkill.build()
}

/**
 * Some extensions for keep things "readable"
 */
inline fun CustomSkillBuilder.handler(block: () -> GenericRequestHandler<HandlerInput, Optional<Response>>) {
    addRequestHandler(block())
}