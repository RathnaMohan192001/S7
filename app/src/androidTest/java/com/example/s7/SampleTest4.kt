package com.example.s7

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(sampleTest1::class,
    SampleTest2::class,
    SampleTest3::class
    )

class SampleTest4 {
}