Source for presentation on the [Play][] Framework, given to a joint meeting of
the Philadelphia Java User's Group ([PhillyJUG][]) and the Philly Area Scala
Enthusiasts ([PHASE][]) on 2 October, 2012.

Requires the following software:

* [Ruby][]
* The [Rake][] build tool
* John MacFarlane's excellent [Pandoc][] tool
* The `lessc` command, to process the [LESS][] stylesheets.

Once you have all that stuff handy, simply run:

    $ rake

to build `slides.html`, a fully self-contained [Slidy][] slide show. Just
open the file in your browser, and away you go.

You'll find the source for the slides in `slides.md`, a Markdown file.
For more information on using [Pandoc][] for slide generation, see
<http://johnmacfarlane.net/pandoc/README.html#producing-slide-shows-with-pandoc>.

You can view a pre-built version of this presentation at
<http://www.ardentex.com/publications/the-play-framework/>.

[Ruby]: http://www.ruby-lang.org/
[Rake]: http://rake.rubyforge.org/
[Bundler]: http://gembundler.com/
[LESS]: http://lesscss.org/
[Pandoc]: http://johnmacfarlane.net/pandoc/
[Play]: http://playframework.org/
[PhillyJUG]: http://phillyjug.skookle.com/
[PHASE]: http://scala-phase.org/
[Slidy]: http://www.w3.org/Talks/Tools/Slidy/
