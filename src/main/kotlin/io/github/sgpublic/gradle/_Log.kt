package io.github.sgpublic.gradle

import org.gradle.api.logging.Logging
import org.slf4j.Logger

interface Loggable

val Loggable.log: Logger get() = Logging.getLogger(javaClass)