(ns mastermind.code-breaker)

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

(defn break-code [past-guesses]
  [0 0 0 0])