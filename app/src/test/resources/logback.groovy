import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.core.spi.FilterReply

def bySecond = timestamp("yyyyMMdd")
def USER_HOME = System.getProperty("user.home")
statusListener(NopStatusListener)
appender("SystemWarn", ConsoleAppender) {
    withJansi = true
    filter(LevelFilter) {
        level = WARN
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%yellow(%-5level %-12logger{0}: %msg) %n"
    }
    target = 'System.err'

}
appender("SystemInfo", ConsoleAppender) {
    withJansi = true
    filter(LevelFilter) {
        level = INFO
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%blue(%-5level %-12logger{0}: %msg) %n"
    }
    target = 'System.out'
}
appender("SystemDebug", ConsoleAppender) {
    withJansi = true
    filter(LevelFilter) {
        level = DEBUG
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%cyan(%-5level %-12logger{0}: %msg) %n"
    }
    target = 'System.out'
}
appender("SystemError", ConsoleAppender) {
    filter(LevelFilter) {
        level = ERROR
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%red(%-5level %-12logger{0}: %msg) %n"
    }
    target = 'System.err'
}

appender("FileLog", FileAppender) {
    file = "salfa.log"
    immediateFlush = true
    encoder(PatternLayoutEncoder) {
        pattern = "%-5level %-12logger{0}: %msg %n"
    }
}
root(ERROR)
logger("avtomatedTestSarafan", DEBUG, ['FileLog', "SystemInfo", 'SystemDebug', 'SystemError', 'SystemWarn'])
//logger("com.aether", DEBUG)
