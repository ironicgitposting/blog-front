(ns blog.components.blog
  (:require ["@mui/material/Grid" :default Grid]
            [blog.components.editor :refer [textarea preview]]))

(defn markdown-render-component [])
(defn markdown-input-component [])

(defn create-article-component [])

(defn blog-panel []
  
  [:> Grid {:container true :mt 5 :spacing 4} 
   [textarea]
   [preview]])