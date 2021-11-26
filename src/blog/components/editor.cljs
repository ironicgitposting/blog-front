(ns blog.components.editor
    (:require [reagent.core :refer [atom]]
              ["@mui/material/Grid" :default Grid]
              ["@mui/material/TextField" :default TextField]
              ["@mui/material/Button" :default Button]
              ["@mui/material/Stack" :default Stack]
              ["react-markdown" :default ReactMarkdown]))

(def inital-value
  "# Write some shit TIA.")

(defonce editor-state (atom {:value inital-value}))

(defn clear-textarea [event]
  (.preventDefault event)
  (reset! editor-state nil))

(defn update-preview [event]
  (.preventDefault event)
  (swap! editor-state assoc :value (.. event -target -value)))

(defn textarea []
  (let [text (:value @editor-state)]
    [:> Grid {:item true :xs 6}
     [:div
      [:> TextField
       {:multiline true
        :rows 4
        :fullWidth  true
        :placeholder inital-value
        :value (if (nil? text) "" text)
       ;:on-focus 
        :on-change #(update-preview %)}]
      [:> Stack {:direction "row" :spacing 2 :mt 1}
        [:> Button {:variant "contained"} "Create Article"]
       [:> Button {:variant "outlined" :on-click #(clear-textarea %) } "Cancel"]]
     ]]))

(defn preview
  []
  (print (:value @editor-state))
  [:> Grid {:item true :xs 6}
   [:div
    [:> ReactMarkdown {:children (:value @editor-state)}]]])