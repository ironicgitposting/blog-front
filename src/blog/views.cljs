(ns blog.views
  (:require
   [re-frame.core :as re-frame]
   [blog.events :as events]
   [blog.routes :as routes]
   [blog.subs :as subs]
   [blog.components.footer :refer [footer-component]]
   [blog.components.header :refer [header-component]]
   [blog.components.about :refer [about-panel]]
   ["@mui/material/CssBaseline" :default CssBaseline]
   ["@mui/material/styles" :refer [ThemeProvider, createTheme]]
   ["@mui/material/Container" :default Container]))


(def base-theme (createTheme (js-obj "palette"
                                     (js-obj "primary" (js-obj "light" "#757ce8"
                                                               "main" "#3f50b5"
                                                               "dark" "#002884"
                                                               "contrastText" "#fff")
                                             "secondary" (js-obj "light" "#ff7961"
                                                                 "main" "#f44336"
                                                                 "dark" "#ba000d"
                                                                 "contrastText" "#000")
                                             "mode" "dark"))))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      (str "Hello from " @name ". This is the Home Page.")]

     [:div
      [:a {:on-click #(re-frame/dispatch [::events/navigate :about])}
       "go to About Page"]]]))

(defmethod routes/panels :home-panel [] [home-panel])

(defmethod routes/panels :about-panel [] [about-panel])
;; main
(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:<>
     [:> ThemeProvider {:theme base-theme}
      [:> CssBaseline]
      [header-component]
      [:> Container {:maxWidth "md"}
       [:div (routes/panels @active-panel)]]
      [footer-component]]]))
