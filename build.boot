(set-env!
 :source-paths    #{"src" "test" "styles"}
 :resource-paths  #{"html" "build"}
 :dependencies    '[[adzerk/boot-cljs   "1.7.48-SNAPSHOT"]
                    [adzerk/boot-reload "0.3.2-SNAPSHOT"]
                    [deraen/boot-less "0.4.0"]
                    [org.clojure/clojurescript "1.7.48"]
                    [pandeiro/boot-http "0.6.3"]])

(require
 '[adzerk.boot-cljs   :refer [cljs]]
 '[adzerk.boot-reload :refer [reload]]
 '[deraen.boot-less :refer [less]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp
   (watch)
   (reload :on-jsload 'frontend.dev/refresh)
   (less)
   (cljs :optimizations :none, :source-map true)
   (serve :port 8080)))

(deftask release []
  (comp
   (less :compression true)
   (cljs :optimizations :advanced)
   (sift :include #{#"(^index\.html|^main\.js|^styles.css)"})))
