(ns blog.components.header
  (:require ["@mui/material/AppBar" :default AppBar]
            ["@mui/material" :refer [Button]]
            ["@mui/material/Toolbar" :default ToolBar]
            ["@mui/material/Typography" :default Typography]
            [blog.subs :as subs]
            [re-frame.core :as re-frame]
            [blog.events :as events]))

(def myFace "img")

(defn header-component []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:> AppBar {:position "static"
                :color "primary"}
     [:> ToolBar
      [:> Typography {:variant "h5"
                      :component "div"
                      :sx (js-obj "flexGrow" 1)
                      :on-click #(re-frame/dispatch [::events/navigate :home])}
       "(0x706174)"]

      [:> Button {:color (if (= @active-panel :home-panel) "secondary" "inherit")
                  :size "large"
                  :on-click #(re-frame/dispatch [::events/navigate :blog])} "Blog"]

      [:> Button {:color (if (= @active-panel :gallery-panel) "secondary" "inherit")
                  :size "large"
                  :on-click #(re-frame/dispatch [::events/navigate :gallery])} "Gallery"]

      [:> Button {:color (if (= @active-panel :about-panel) "secondary" "inherit")
                  :size "large"
                  :on-click #(re-frame/dispatch [::events/navigate :about])} "About"]]]))
