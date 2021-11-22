(ns blog.views
  (:require
   [re-frame.core :as re-frame]
   [blog.events :as events]
   [blog.routes :as routes]
   [blog.subs :as subs]
   [blog.components.appbar :refer [appbar-component]]  
   ["@mui/material/CssBaseline" :default CssBaseline]
   ["@mui/material/styles" :refer [ThemeProvider, createTheme]]
   ["@mui/material/Container" :default Container]))


(def base-theme (createTheme (js-obj "palette" 
                                     (js-obj "mode" "dark"))))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      (str "Hello from " @name ". This is the Home Page.")]

     [:div
      [:a {:on-click #(re-frame/dispatch [::events/navigate :about])}
       "go to About Page"]]
     ]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])
;; main
(defn main-panel [] 
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:<>    
     [:> ThemeProvider {:theme base-theme}
      [:> CssBaseline]
      [appbar-component]
      [:> Container      
       [:div (routes/panels @active-panel)]]]]))
