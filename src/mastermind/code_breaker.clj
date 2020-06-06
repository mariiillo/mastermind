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
      (let [past-guess (first past-guesses)
            score (cm/score guess (first past-guess))]
        (if (= score (second past-guess))
          guess
          (recur (inc-guess guess)))))))

(defn break-code [last-guess past-guesses]
  (if (nil? last-guess)
    [0 0 0 0]
    (next-guess last-guess past-guesses)))