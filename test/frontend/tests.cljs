(ns frontend.tests
  (:require
   [cljs.test :as t :refer-macros [deftest is testing run-tests]]
   [frontend.app :as app]))

;; Tests

(deftest sample-test
  (testing "default value"
    (is (not (nil? app/default-value)))))

;; Entrypoint

(defn run []
  (enable-console-print!)
  (println "Running tests...")
  (run-tests))
