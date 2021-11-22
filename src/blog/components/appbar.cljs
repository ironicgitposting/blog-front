(ns blog.components.appbar
  (:require ["@mui/material/AppBar" :default AppBar]
            ["@mui/material" :refer [Button]]
            ["@mui/material/Toolbar" :default ToolBar]
            ["@mui/material/Typography" :default Typography]
            [re-frame.core :as re-frame]
            [blog.events :as events]))

(defn appbar-component []
  [:> AppBar {:position "static"
              :color "primary"}
   
   [:> ToolBar
    [:> Typography {:variant "h6"
                    :component "div"
                    :sx (js-obj "flexGrow" 1)
                    :on-click #(re-frame/dispatch [::events/navigate :home])}
     "0x"]
     [:> Button {:color "inherit"
                 :on-click #(re-frame/dispatch [::events/navigate :home])} "Blog"]
     [:> Button {:color "inherit"
                 :on-click #(re-frame/dispatch [::events/navigate :about])} "About"]]])

