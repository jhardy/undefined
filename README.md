# undefined

## Prerequisites

You will need:

  * [Leiningen][1] 1.7.0 or above
  * [Bundler][2] 1.2.1 or above

[1]: https://github.com/technomancy/leiningen
[2]: http://gembundler.com/

## Running

To start a web server for the application, run:

    lein ring server

To begin watching and compiling sass, first ensure the necessary gems are
installed:

    bundle install

Then run:

    compass watch
