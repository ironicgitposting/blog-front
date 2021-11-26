(ns blog.components.editor
    (:require [reagent.core :refer [atom]]
            ["react-markdown" :default ReactMarkdown]))

(def inital-value
  "### Write some shit TIA.")

(defonce editor-state (atom {:value inital-value}))

(defn clear-textarea [event]
  (.preventDefault event)
  (reset! editor-state nil))

(defn update-preview [event]
  (.preventDefault event)
  (swap! editor-state assoc :value (.. event -target -value)))

(defn textarea []
  (let [text (:value @editor-state)]
    [:div
     [:textarea
      {
       :placeholder text
       :value text
       :on-focus #(clear-textarea %)
       :on-change #(update-preview %)
      }]]))

(defn preview
  []
  [:div 
   [:> ReactMarkdown {:children (:value @editor-state)}]])