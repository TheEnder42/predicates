(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k))) ;error why?

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k)))) 

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= nil string) ;java.lang.String cannot be cast to java.lang.Number (dunno, but works)
      (empty? string)
      (every? whitespace? string)))



(def china2 {:name "China Miéville", :birth-year 1972})
(def octavia2 {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def kay2 {:name "Guy Gavriel Kay" :birth-year 1954})
(def dick2 {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
(def zelazny2 {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

(def authors2 #{china2, octavia2, kay2, dick2, zelazny2})

(def cities2 {:title "The City and the City" :authors #{china2}
             :awards #{:locus, :world-fantasy, :hugo}})
(def wild-seed2 {:title "Wild Seed", :authors #{octavia2}})
(def lord-of-light2 {:title "Lord of Light", :authors #{zelazny2}
                    :awards #{:hugo}})
(def deus-irae2 {:title "Deus Irae", :authors #{dick2, zelazny2}})
(def ysabel2 {:title "Ysabel", :authors #{kay2}, :awards #{:world-fantasy}})
(def scanner-darkly2 {:title "A Scanner Darkly" :authors #{dick2}})

(def books2 #{cities2, wild-seed2, lord-of-light2,
             deus-irae2, ysabel2, scanner-darkly2})



(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [passed (filter #(has-award? book %) awards)]
  (= (count awards) (count passed))
   ))

(defn my-some [pred a-seq]
  (not (empty? (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count (filter pred a-seq)) (count a-seq)))

(defn prime? [n]
  (let [pred #(= (mod n %) 0)]
    (not (some pred (range 2 n)))))
;^^
