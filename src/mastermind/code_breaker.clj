(ns mastermind.code-breaker
  (:require [mastermind.code-maker :as cm]))

(defn guess-to-number [guess]
  (reduce #(+ (* 6 %1) %2) guess))

(defn number-to-guess [number]
  [(rem (quot number 216) 6)
   (rem (quot number 36) 6)
   (rem (quot number 6) 6)
   (rem number 6)]
  )

(defn inc-guess [guess]
  (->> guess
       (guess-to-number)
       (inc)
       (number-to-guess)))

(defn next-guess [last-guess past-guesses]
  (loop [guess (inc-guess last-guess)]
    (if (= guess [0 0 0 0])
      :error
      (if (every? identity (for [past-guess past-guesses]
                             (= (cm/score guess (first past-guess))
                                (second past-guess))))
        guess
        (recur (inc-guess guess))))))

(defn break-code-seq
  "Sequential Strategy"
  [last-guess past-guesses]
  (if (nil? last-guess)
    [0 0 0 0]
    (next-guess last-guess past-guesses)))

(defn break-code-3x2
  "The 3x2 Strategy"
  [last-guess past-scores]
  (case (count past-scores)
    0 [0 0 1 1]
    1 [2 2 3 3]
    2 [4 4 5 5]
    3 (next-guess [0 0 0 0] past-scores)
    (next-guess last-guess past-scores)))

(defn break-code-double-rainbow
  "Double Rainbow Strategy"
  [last-guess past-scores]
  (case (count past-scores)
    0 [0 1 2 3]
    1 [2 3 4 5]
    2 [4 5 0 1]
    3 (next-guess [0 0 0 0] past-scores)
    (next-guess last-guess past-scores)))