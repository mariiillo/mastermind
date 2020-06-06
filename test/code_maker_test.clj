(ns code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Code maker"
  (fact
    "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [])
  (fact
    "score guess with on :pos match"
    (score [0 0 0 0] [0 1 1 1]) => [:pos])
  (fact
    "guess with two :pos matches"
    (score [0 0 0 0] [0 1 1 0]) => [:pos :pos]))
