(ns mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-breaker :refer :all]))

(fact "Code Breaker"
      (fact "initial guess"
            (break-code []) => [0 0 0 0]))