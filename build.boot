(set-env!
 :source-paths    #{"src"}
 :resource-paths  #{"html" "conf"}
 :dependencies    '[[adzerk/boot-cljs   "0.0-2629-8"]
                    [adzerk/boot-reload "0.2.3"]
                    [pandeiro/boot-http "0.5.0"]])

(require
 '[adzerk.boot-cljs   :refer [cljs]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp
   (watch)
   (cljs :optimizations    :none
         :source-map       true
         :compiler-options {:cache-analysis true})
   (serve :dir "target", :port 8080)))

