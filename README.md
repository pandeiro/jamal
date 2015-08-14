# jamal

A [minimal](https://www.youtube.com/watch?v=FU1hm7KlfT8) ClojureScript template using Boot.

- Auto-compiles ClojureScript and LESS in development
- Includes ClojureScript tests
- Produces minified release build

## Usage

### Development

Create a new project:

```
git clone git://github.com/pandeiro/jamal myapp
cd myapp
```

Run the development server with auto-compilation and auto-testing:

```
boot dev
```

See the results in your browser:

- App: [http://localhost:8080](http://localhost:8080)
- Tests: [http://localhost:8080/tests.html](http://localhost:8000/tests.html) (results printed to the dev console)

You should see each update automatically if any HTML, styles or
ClojureScript files are changed on disk.

### Release

Compile once using minification:

```
boot release
```

Assets will be in the `target` directory.


## License

Copyright © 2015 Murphy McMahon

Original mies template
Copyright © 2013 David Nolen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
