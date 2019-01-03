(require '[hodur-datomic-schema.core :as hodur-datomic]
         '[hodur-engine.core :as hodur]))

(def meta-db 
  (hodur/init-schema
    '[^{:datomic/tag-recursive true}
      User [
        ^{:type String      } username 
        ^{:type DateTime    } created-on 
        ^{:type String      } github-name
        ^{:type String      } github-email
        ^{:type String  
          :optional true    } github-company
        ^{:type String  
          :optional true    } github-location
        ^{:type Boolean 
          :optional true    } github-hireable
        ^{:type String  
          :optional true    } github-bio
        ^{:type String
          :cardinality [0 n]
          :optional true    } tags
        ^{:type Group
          :cardinality [0 n]
          :optional true    } groups
        ]
      
      Group [
        ^{:type String      } name
        ^{:type String      } description
        ^{:type User        } mentor
        ^{:type User
          :cardinality [0 n]} moderators
        ^{:type String      } chat-url
        ^{:type String
          :cardinality [0 n]
          :optional true    } tags
        ^{:type Project
          :cardinality [0 n]} projects]
      
      Project [
        ^{:type String      } name
        ^{:type User        } owner
        ^{:type User
          :cardinality [0 n]} moderators
        ^{:type String      } github-url
        ^{:type String      } description
        ^{:type String
          :cardinality [0 n]
          :optional true    } tags
        ]]))
