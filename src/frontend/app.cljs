(ns frontend.app
  (:require
   [devtools.core :as devtools]))

(enable-console-print!)

(def default-value :default)

(defn init []
  (devtools/install!)
  (println :hello-world))
