Source for Philly Area Scala Enthusiasts [PHASE][] presentation on Typesafe
[Slick][], given on 19 March, 2015.

Requires the following software:

* [Ruby][]
* The [Rake][] build tool
* John MacFarlane's excellent [Pandoc][] tool
* The `lessc` command, to process the [LESS][] stylesheets.

Once you have all that stuff handy, simply run:

    $ rake

to build `index.html`, a fully self-contained [Reveal.js][] slide show. Just
open the file in your browser, and away you go.

The build also creates `slides.pdf`, a PDF version of the slides.

You'll find the source for the slides in `slides.md`, a Markdown file.
For more information on using [Pandoc][] for slide generation, see
<http://johnmacfarlane.net/pandoc/README.html#producing-slide-shows-with-pandoc>.

[Ruby]: http://www.ruby-lang.org/
[Rake]: http://rake.rubyforge.org/
[Bundler]: http://gembundler.com/
[LESS]: http://lesscss.org/
[Pandoc]: http://johnmacfarlane.net/pandoc/
[Slick]: http://slick.typesafe.com/
[PHASE]: http://scala-phase.org/
[Reveal.js]: https://github.com/hakimel/reveal.js
