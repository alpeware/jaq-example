# jaq-test

A sample repo to demo how to use lein-jaq to develop a ring based Web app for Google App Engine Standard Java.

## Prerequisite
- a free Google Account [create new account](https://accounts.google.com/signup)
- accepted Google Cloud T&Cs [login to Cloud Console](https://console.cloud.google.com)

## Usage

### Setup
- clone this repo
- ```lein deps```
- change ```project.clj```:
 - ```project-id``` - this must be a unique name across all of Google Cloud

### Auth
This is only required the first time you setup a project to grant access to the Google Cloud APIs.

- ```lein jaq auth-token```

### Google Cloud Project & App Engine Application
This will create the project and a new application. Make sure the project-id specified in your ```project.clj``` is unique.

- ```lein jaq create-project```
- ```lein jaq create-application```

### SDK
This is only required the first time or whenever you change the version of the App Engine SDK.

- ```lein jaq unpack```

### Dev
This will package up your source code into a uberwar, explode it into a local directory and then run the dev-server.

Please note that you need to re-run these steps each time you make a change to the source files (you can of course connect a REPL).

You can also just copy over your .clj files into the ```war/WEB-INF/classes``` directory as well as long as you're not AOTing.

- ```lein jaq uberwar```
- ```lein jaq explode```
- ```lein jaq dev-server```

You can access the dev server's admin console at [http://localhost:3000/_ah/admin](http://localhost:3000/_ah/admin)

### REPL
The sample will start a default socket REPL and bind it to port 10010. In order to use any of the App Engine specific APIs in the REPL
you will need to install the Remote API on the REPL's thread. You can do this by calling ```(jaq.core/remote!)``` once per REPL session.

You can also use the Remote API to connect to a production instance from a REPL - [Remote API docs](https://cloud.google.com/appengine/docs/standard/java/tools/remoteapi).

You can try a nREPL as well and you'll have to install the Remote API on each thread as well. It works, but my experience has been that
nREPL spawns more threads than just one per request, so I now recommend the standard REPL over nREPL.

### Deploy
Make sure you have packaged up the most recent version and changed the ```version``` and ```code-prefix``` value in your ```project.clj```.

- ```lein jaq upload```
- ```lein jaq deploy```
- ```lein jaq migrate```

## License

Copyright © 2017 Alpeware, LLC.

Distributed under the Eclipse Public License, the same as Clojure.
