(ns k8listns-clj.core
  (:require [clojure.java.io :as io] )
  (:import [io.kubernetes.client.util ClientBuilder]
           [io.kubernetes.client.util KubeConfig]
           [io.kubernetes.client Configuration]
           [io.kubernetes.client.apis CoreV1Api])
  (:gen-class))

(defn -main
  "List all namespaces on current configured Kubernetes cluster"
  [& args]

  (Configuration/setDefaultApiClient
   (.build
    (ClientBuilder/kubeconfig
     (KubeConfig/loadKubeConfig
      (io/reader (str (System/getenv "HOME") "/.kube/config"))))))

  (doseq [item
          (.getItems
           (.listNamespace (CoreV1Api.) nil nil nil nil nil nil nil nil))]
    (println (.getName (.getMetadata item)))))
