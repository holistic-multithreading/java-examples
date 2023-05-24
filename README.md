# run benchamrk

```bash
gradle jmh
```

run in Docker

```bash
docker run -it -v "$PWD":/code gradle sh
cd /code
gradle jmh
```
