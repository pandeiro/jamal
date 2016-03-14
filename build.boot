(set-env!
 :source-paths    #{"src" "test" "styles"}
 :resource-paths  #{"html" "build"}
 :dependencies    '[[adzerk/boot-cljs          "1.7.228-1"]
                    [adzerk/boot-reload        "0.4.5"]
                    [deraen/boot-less          "0.5.0"]
                    [org.clojure/clojurescript "1.7.228"]
                    [pandeiro/boot-http        "0.7.0"]
                    [binaryage/devtools        "0.5.2"]])

(require
 '[adzerk.boot-cljs   :refer [cljs]]
 '[adzerk.boot-reload :refer [reload]]
 '[deraen.boot-less   :refer [less]]
 '[pandeiro.boot-http :refer [serve]])

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
   (cljs :ids #{"main"} :optimizations :advanced)
   (sift :include #{#"(^index\.html|^main\.js|^styles.css)"})
   (target :dir #{"target"})))
