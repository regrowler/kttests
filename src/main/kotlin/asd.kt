@Immutable
class GradientShaderBrush(
    private val getCenter: (Size) -> Offset,
    private val getRadius: (Size) -> Float,
    private val colors: List<Color>,
    private val stops: List<Float>
) : ShaderBrush() {
    override fun createShader(size: Size): Shader = RadialGradientShader(
        center = getCenter(size),
        radius = getRadius(size),
        colors = colors.toList(),
        colorStops = stops.toList()
    )
}

@Composable
@Preview
private fun GradientPreview() {
    VkcTheme {
        Column {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush = VkcTheme.colorSystem.gradients.mars)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush = VkcTheme.colorSystem.gradients.uranus)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush = VkcTheme.colorSystem.gradients.neptune)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush = VkcTheme.colorSystem.gradients.jupiter)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush = VkcTheme.colorSystem.gradients.earth)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

internal object GradientsInstance : Gradients {
    override val mars = GradientShaderBrush(
        getCenter = { Offset(it.width, it.height * 1.0857f) },
        getRadius = { it.width * 1.4156f },
        colors = listOf(
            Color(0xFF360E44),
            Color(0xFFBA3C71),
            Color(0xFFFF857B)
        ),
        stops = listOf(0f, 0.501f, 1f)
    )
    override val uranus = GradientShaderBrush(
        getCenter = {
            Offset(it.width * 0.562f, it.height)
        },
        getRadius = {
            it.height
        },
        colors = listOf(
            Color(0xFF32087D),
            Color(0xFF374CF1),
            Color(0xFFBB77FF)
        ),
        stops = listOf(0f, 0.6025f, 1f)
    )
    override val neptune = GradientShaderBrush(
        getCenter = {
            Offset(it.width, it.height * 0.9134f)
        },
        getRadius = {
            it.height * 1.2392f
        },
        colors = listOf(
            Color(0xFF53FFB7),
            Color(0xFF12B3DE),
            Color(0xFF00337E)
        ),
        stops = listOf(0f, 0.4466f, 1f)
    )
    override val jupiter = GradientShaderBrush(
        getCenter = {
            Offset(it.width, it.height * 0.7453f)
        },
        getRadius = {
            it.height * 1.0715f
        },
        colors = listOf(
            Color(0xFFFF4141),
            Color(0xFFFB9C4C),
            Color(0xFFDD6300)
        ),
        stops = listOf(0f, 0.6124f, 1f)
    )
    override val earth = GradientShaderBrush(
        getCenter = {
            Offset(it.width * 0.1447f, it.height * 1.0963f)
        },
        getRadius = {
            it.height * 1.2383f
        },
        colors = listOf(
            Color(0xFF88FF5F),
            Color(0xFF10AB87),
            Color(0xFF044235)
        ),
        stops = listOf(0f, 0.6179f, 1f)
    )
}