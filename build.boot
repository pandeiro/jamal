(set-env!
 :source-paths    #{"src"}
 :resource-paths  #{"html" "conf"}
 :dependencies    '[[adzerk/boot-cljs   "0.0-2814-3"]
                    [adzerk/boot-reload "0.2.6"]
                    [pandeiro/boot-http "0.6.2"]])

(require
 '[adzerk.boot-cljs   :refer [cljs]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp
   (watch)
   (reload :on-jsload 'app/init)
   (cljs :optimizations :none, :source-map true)
   (serve :dir "target", :port 8080)))

(deftask release []
  (comp
   (cljs :optimizations :advanced)
   (sift :include #{#"(^index\.html|^main\.js)"})))
