(ns code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Code maker"
  (fact
    "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [0])
  (fact
    "score guess one match"
    (score [0 0 0 0] [0 1 1 1]) => [1])
  (fact
    "guess with two matches"
    (score [0 0 0 0] [0 1 1 0]) => [2]))
