(ns blog.components.appbar
  (:require ["@mui/material/AppBar" :default AppBar]
            ["@mui/material/Toolbar" :default ToolBar]
            ["@mui/material/Typography" :default Typography]))

(defn appbar-component []
  [:> AppBar {:position "static"
              :color "primary"}
   [:> ToolBar
    [:> Typography {:variant "h6" 
                   :component "div" 
                   } 
    "Home"]]])

