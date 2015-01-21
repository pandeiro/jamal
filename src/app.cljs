(ns app
  (:require [clojure.browser.repl :as repl]))

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(defn init []
  (println "Hello world!"))
