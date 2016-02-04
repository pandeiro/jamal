(set-env!
 :source-paths    #{"src" "test" "styles"}
 :resource-paths  #{"html" "build"}
 :dependencies    '[[adzerk/boot-cljs          "1.7.48-6"]
                    [adzerk/boot-reload        "0.4.1"]
                    [deraen/boot-less          "0.4.2"]
                    [org.clojure/clojurescript "1.7.145"]
                    [pandeiro/boot-http        "0.7.0"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-reload    :refer [reload]]
 '[deraen.boot-less      :refer [less]]
 '[pandeiro.boot-http    :refer [serve]])

(deftask dev []
  (comp
   (watch)
   (reload :on-jsload 'frontend.dev/refresh)
   (less)
   (cljs)
   (serve :port 8080)))

(deftask release []
  (comp
   (less :compression true)
   (cljs :optimizations :advanced)
   (sift :include #{#"(^index\.html|^main\.js|^styles.css)"})))
