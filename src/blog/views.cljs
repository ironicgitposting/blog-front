(ns blog.views
  (:require
   [re-frame.core :as re-frame]
   [blog.events :as events]
   [blog.routes :as routes]
   [blog.subs :as subs]
   ))


;; (def base-theme (createMuiTheme (clj->js {:palette #js {:primary {:main "red"}}})))

;; home

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
    [:div "this is on every page"
     [:div (routes/panels @active-panel)]]))