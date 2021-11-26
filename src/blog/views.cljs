(ns blog.views
  (:require
   [re-frame.core :as re-frame]
   [blog.events :as events]
   [blog.routes :as routes]
   [blog.subs :as subs]
   [blog.components.footer :refer [footer-component]]
   [blog.components.header :refer [header-component]]
   [blog.components.about :refer [about-panel]]
   [blog.components.blog :refer [blog-panel]]
   [blog.components.gallery :refer [gallery-panel]]
   ["@mui/material/CssBaseline" :default CssBaseline]
   ["@mui/material/styles" :refer [ThemeProvider, createTheme]]
   ["@mui/material/Container" :default Container]))


(def base-theme (createTheme (js-obj "palette"
                                     (js-obj "primary" (js-obj "light" "#757ce8"
                                                               "main" "#3f50b5"
                                                               "dark" "#ff0000"
                                                               "contrastText" "#fff")
                                             "secondary" (js-obj "light" "#ff7961"
                                                                 "main" "#f44336"
                                                                 "dark" "#ba000d"
                                                                 "contrastText" "#000")
                                             "mode" "dark"))))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    (js-debugger)
    [:div
     [:h1
      (str "Hello from " @name ". This is the Home Page.")]     
     [:div
      [:a {:on-click #(re-frame/dispatch [::events/navigate :about])}
       "go to About Page"]]]))

(defmethod routes/panels :home-panel [] [home-panel])

(defmethod routes/panels :about-panel [] [about-panel])

(defmethod routes/panels :blog-panel [] [blog-panel])

(defmethod routes/panels :gallery-panel [] [gallery-panel])
;; main
(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:<>
     [:> ThemeProvider {:theme base-theme}
      [:> CssBaseline]
      [header-component]
      [:> Container {:maxWidth (if (not (= @active-panel :blog-panel)) "md" "lg")}
       [:div (routes/panels @active-panel)]]
      [footer-component]]]))
