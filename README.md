# jaq-test

A sample repo to demo JAQ at the Clojure Meetup in Amsterdam

## Usage

Setup
- clone this repo
- lein deps
- change project.clj:
 - project-id
 - bucket

Auth
- lein jaq auth-token
- lein jaq create-project
- lein jaq create-application

SDK
- lein jaq unpack

Dev
- lein jaq uberwar
- lein jaq unpack
- lein jaq dev-server

Deploy
- lein jaq upload
- lein jaq deploy
- lein jaq migrate

## License

Copyright © 2017 Alpeware, LLC.

Distributed under the Eclipse Public License, the same as Clojure.
