(ns code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Code maker"
  (fact
    "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [0 0])
  (fact
    "score guess one match"
    (score [0 0 0 0] [0 1 1 1]) => [1 0])
  (fact
    "guess with two matches"
    (score [0 0 0 0] [0 1 1 0]) => [2 0])
  (fact
    "guess with many position matches"
    (score [1 1 1 1] [0 1 1 1]) => [3 0]
    (score [0 0 0 0] [0 0 0 1]) => [3 0]
    (score [1 2 3 4] [1 2 3 4]) => [4 0])
)
