(ns blog.components.footer
  (:require   ["@mui/material/AppBar" :default AppBar]
              [re-frame.core :as re-frame]
              [blog.events :as events]))

(defn footer-component []
  [:> AppBar])
