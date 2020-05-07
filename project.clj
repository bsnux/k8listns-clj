(defproject k8listns-clj "0.1.0"
  :description "List namespaces for current cluster"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [io.kubernetes/client-java "6.0.1"]
                 [org.slf4j/slf4j-jdk14 "1.7.30"]]
  :main ^:skip-aot k8listns-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
