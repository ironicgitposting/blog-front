(ns blog.components.about
  (:require ["@mui/material/Typography" :default Typography]
            ["@mui/material/Stack" :default Stack]))

(defn about-panel []
  [:div
   [:h1 "About Me."]
   [:div
    [:> Stack {:spacing 2}

     [:> Typography {:variant "p"
                     :fontSize 18}
      "Hi I am Patrick and I am a Software Engineer working full-time in France. 
      I come from a remote french island in the middle of the Indian Ocean known as Réunion island."]

     [:> Typography {:variant "p"
                     :fontSize 18}
      "I graduated from an engineering school in Nantes and I hold 2 masters in Software Engineering and 
       Information Systems Management."]

     [:> Typography {:variant "p"
                     :fontSize 18}
      "I specialize in building enterprise software using JavaScript (ExtJs, React but also ClojureScript these days!), Node and JVM languages
      (Clojure and modern Java). I am lucky to learn new stuff on a daily basis working with brillant engineers at HerculePro."]


     [:> Typography {:variant "p"
                     :fontSize 18}
      "My current passions include functional programming, cybersecurity and language learning. I am still waiting for my first Clojure gig and I am currently working toward 
       moving to Japan in the upcoming year."]

     [:> Typography {:variant "p"
                     :fontSize 18}
      "When I am not coding, I am either in nature or hacking the gibson at HtB."]]]])
